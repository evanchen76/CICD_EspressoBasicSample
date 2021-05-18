package evan.chen.tutorial.tdd.espressobasic

import org.junit.Test
import org.junit.Assert.*

class RegisterVerifyTest {

    @Test
    fun loginVerifyTrue() {
        val registerVerify = RegisterVerify()
        val isVerifyOK = registerVerify.loginIdVerify("A123456")
        assertTrue(isVerifyOK)
    }

    @Test
    fun loginVerifyFalse() {
        val registerVerify = RegisterVerify()
        val isVerifyOK = registerVerify.loginIdVerify("A1234")
        assertFalse(isVerifyOK)
    }
}