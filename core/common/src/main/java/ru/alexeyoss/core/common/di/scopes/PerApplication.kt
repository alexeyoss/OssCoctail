package ru.alexeyoss.core.common.di.scopes

import javax.inject.Scope

/**
 * Application-level dagger scope
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication 