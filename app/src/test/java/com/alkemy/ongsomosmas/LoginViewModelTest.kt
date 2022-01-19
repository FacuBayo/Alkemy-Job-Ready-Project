package com.alkemy.ongsomosmas

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.alkemy.ongsomosmas.data.Preferences
import com.alkemy.ongsomosmas.ui.login.LoginFormState
import com.alkemy.ongsomosmas.ui.login.LoginViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var preferences: Preferences

    @Mock
    lateinit var observer: Observer<LoginFormState>

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel(preferences)
    }

    @Test
    fun invalidEmail() {
        // Given
        viewModel.loginFormState.observeForever(observer)

        // When
        viewModel.loginDataChanged("21@", "1235test")

        // Then
        Mockito.verify(observer).onChanged(loginFormStateEmailError)
    }

    @Test
    fun invalidPassword() {
        // Given
        viewModel.loginFormState.observeForever(observer)

        // When
        viewModel.loginDataChanged("test@email.com", "test")

        // Then
        Mockito.verify(observer).onChanged(loginFormStatePasswordError)
    }

    @Test
    fun emptyEmail(){
        // Given
        viewModel.loginFormState.observeForever(observer)

        // When
        viewModel.loginDataChanged("", "1234test")

        // Then
        Mockito.verify(observer).onChanged(loginFormStateEmailError)
    }

    @Test
    fun emptyPassword(){
        // Given
        viewModel.loginFormState.observeForever(observer)

        // When
        viewModel.loginDataChanged("test@email.com", "")

        // Then
        Mockito.verify(observer).onChanged(loginFormStatePasswordError)
    }

    @Test
    fun validFields(){
        // Given
        viewModel.loginFormState.observeForever(observer)

        // When
        viewModel.loginDataChanged("test@email.com", "test12345")

        // Then
        Mockito.verify(observer).onChanged(loginFormStateSuccess)
    }
}