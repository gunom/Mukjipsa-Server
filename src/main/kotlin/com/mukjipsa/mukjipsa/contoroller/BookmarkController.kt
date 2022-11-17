package com.mukjipsa.mukjipsa.contoroller

import com.mukjipsa.mukjipsa.facade.BookmarkFacade
import com.mukjipsa.mukjipsa.service.AuthService
import com.mukjipsa.mukjipsa.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bookmark")
class BookmarkController(
    private val bookmarkFacade: BookmarkFacade,
    private val authService: AuthService,
) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getBookmarkRecipe(){
        // TODO 북마크한 레시피 리턴
        log.info("bookmarkList")
    }

    @PostMapping
    fun toggleBookmark(recipeId: Int) {
        val userId = authService.getUserId()
        bookmarkFacade.toggleBookmark(userId, recipeId)
    }
}