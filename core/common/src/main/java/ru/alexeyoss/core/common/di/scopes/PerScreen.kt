package ru.alexeyoss.core.common.di.scopes

import javax.inject.Scope

/**
 * Screen-level dagger scope
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen 