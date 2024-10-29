package com.github.craftscat.kemuri.fir

import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

/**
 * Class to register FIR extensions defined in Kemuri.
 * @see ImplicitVisibilityInternalizerExtension
 */
class KemuriFirExtensionRegistrar : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +::ImplicitVisibilityInternalizerExtension
    }
}
