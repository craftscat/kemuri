package com.github.craftscat.kemuri

import com.github.craftscat.kemuri.fir.KemuriFirExtensionRegistrar
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrarAdapter

/**
 * Class to register Kemuri compiler extensions.
 * @see KemuriFirExtensionRegistrar
 */
@ExperimentalCompilerApi
class KemuriCompilerPluginRegistrar : CompilerPluginRegistrar() {
    override val supportsK2: Boolean = true
    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        FirExtensionRegistrarAdapter.registerExtension(KemuriFirExtensionRegistrar())
    }
}
