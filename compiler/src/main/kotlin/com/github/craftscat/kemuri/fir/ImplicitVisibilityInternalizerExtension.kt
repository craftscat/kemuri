package com.github.craftscat.kemuri.fir

import org.jetbrains.kotlin.descriptors.Visibilities
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.analysis.checkers.getModifier
import org.jetbrains.kotlin.fir.copy
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.declarations.FirDeclarationStatus
import org.jetbrains.kotlin.fir.extensions.FirStatusTransformerExtension
import org.jetbrains.kotlin.lexer.KtTokens

/**
 * FIR extension to change default visibility to `internal`.
 */
class ImplicitVisibilityInternalizerExtension(session: FirSession) : FirStatusTransformerExtension(session) {
    /**
     * Check if the visibility of the FIR declaration needs to be transformed.
     * @param declaration FIR declaration to check
     * @return `true` if the visibility of the declaration needs to be transformed, `false` otherwise
     */
    override fun needTransformStatus(declaration: FirDeclaration): Boolean {
        // Transform only if the visibility modifier is not explicitly specified.
        return !hasExplicitVisibility(declaration)
    }

    /**
     * Change the visibility of the FIR declaration to `internal` if it is not explicitly specified.
     * @param status Original status of the FIR declaration
     * @param declaration FIR declaration to transform
     * @return Transformed status of the FIR declaration
     */
    override fun transformStatus(status: FirDeclarationStatus, declaration: FirDeclaration): FirDeclarationStatus {
        // The visibility modifier is not explicitly specified, so it is guaranteed here.
        return status.copy(visibility = Visibilities.Internal)
    }

    /**
     * Check if the FIR declaration has an explicit visibility modifier.
     * @param declaration FIR declaration to check
     * @return `true` if the declaration has an explicit visibility modifier, `false` otherwise
     */
    private fun hasExplicitVisibility(declaration: FirDeclaration): Boolean {
        return explicitVisibilityTokens.any { token ->
            declaration.getModifier(token) != null
        }
    }

    /**
     * Tokens for explicit visibility modifiers.
     */
    private val explicitVisibilityTokens = setOf(
        KtTokens.PUBLIC_KEYWORD,
        KtTokens.PRIVATE_KEYWORD,
        KtTokens.PROTECTED_KEYWORD,
        KtTokens.INTERNAL_KEYWORD,
    )
}
