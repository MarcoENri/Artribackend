package com.example.artribackend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {
    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val corsConfiguration = CorsConfiguration()

        corsConfiguration.allowedOrigins = listOf("http://localhost:5173", "http://artri.sudamericano.edu.ec:5173", "http://34.125.86.215:5173", "https://artri.sudamericano.edu.ec")
        corsConfiguration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS")
        corsConfiguration.allowedHeaders = listOf("*")
        corsConfiguration.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/", corsConfiguration)

        return source
    }
}