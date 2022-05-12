package br.com.gustavodiniz.forum.configs

import br.com.gustavodiniz.forum.models.UserModel
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val userModel: UserModel
) : UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = userModel.password

    override fun getUsername() = userModel.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}