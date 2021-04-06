package com.example.customerprocessor

import com.example.customerannotation.FeatureService
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.IOException
import java.util.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.tools.Diagnostic

@SupportedSourceVersion(SourceVersion.RELEASE_8)
class CustomerProcessor : AbstractProcessor() {
    private var messager: Messager? = null

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(FeatureService::class.java.name)
    }

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        messager = processingEnv.messager
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val annotationElement = roundEnv.getElementsAnnotatedWith(FeatureService::class.java)
        for (element in annotationElement) {
            if (!element.kind.isInterface) {
                return true
            }

            messager?.printMessage(Diagnostic.Kind.WARNING, "Start process")
            val typeElement = element as TypeElement
            //create class for interface
            createImplFile(typeElement)
        }

        return true
    }

    private fun createImplFile(typeElement: TypeElement) {
        val classNameBuilder = TypeSpec.classBuilder("Default${typeElement.simpleName}Impl")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addSuperinterface(typeElement.asType())

        for (methodElement in typeElement.enclosedElements) {
            methodElement as ExecutableElement
            messager?.printMessage(Diagnostic.Kind.WARNING, methodElement.returnType.toString())

            val methodBuilder = MethodSpec.methodBuilder(methodElement.simpleName.toString())
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.get(methodElement.returnType))
                .addStatement("android.util.Log.e(\"Tag\", \"Not Support ${typeElement.simpleName}\")")

            //return something
            if (methodElement.returnType.kind.isPrimitive) {
                when (methodElement.returnType.kind) {
                    TypeKind.CHAR -> methodBuilder.addStatement("return 'a'")
                    TypeKind.BOOLEAN -> methodBuilder.addStatement("return true")
                    TypeKind.INT, TypeKind.LONG, TypeKind.SHORT, TypeKind.FLOAT, TypeKind.DOUBLE, TypeKind.BYTE -> methodBuilder.addStatement("return 0")
                    else -> {}
                }

            } else if (methodElement.returnType.kind != TypeKind.VOID) {
                methodBuilder.addStatement("return new ${ClassName.get(methodElement.returnType)}()")
            }

            //parameters
            for (variableElement in methodElement.parameters) {
                methodBuilder.addParameter(
                    ClassName.get(variableElement.asType()), variableElement.simpleName.toString().toLowerCase(Locale.ROOT))
            }

            classNameBuilder.addMethod(methodBuilder.build())
        }

        val packageName = processingEnv.elementUtils.getPackageOf(typeElement).qualifiedName.toString()
        val javaFile = JavaFile.builder(packageName, classNameBuilder.build()).build()

        try {
            val filer = processingEnv.filer
            javaFile.writeTo(filer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}