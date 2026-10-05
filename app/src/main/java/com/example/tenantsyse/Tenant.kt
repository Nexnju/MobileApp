package com.example.tenantsyse

data class Tenant (
    val name: String,
    val phone: String,
    val rent: String)
{
    fun Summary(): String {
        return "Tenant: $name\n Phone:$phone\n Rent:KSH$rent"
    }

}