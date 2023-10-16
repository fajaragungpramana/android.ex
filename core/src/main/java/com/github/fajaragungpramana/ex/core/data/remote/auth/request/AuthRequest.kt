package com.github.fajaragungpramana.ex.core.data.remote.auth.request

import com.github.fajaragungpramana.ex.core.constant.Http
import com.github.fajaragungpramana.ex.core.extension.removeNulls

data class AuthRequest(
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var confirmPassword: String? = null
) : Map<String, Any> by mapOf(
    Http.Param.ID to id,
    Http.Param.NAME to name,
    Http.Param.EMAIL to email
).removeNulls()