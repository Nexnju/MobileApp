package com.example.tenantsyse

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,
) {
    fun summary(): String {
        return "Tenant: $name\n Phone:$phone\n Rent paid:KSH $rent"
    }
}
