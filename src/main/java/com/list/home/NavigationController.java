package com.list.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    private final List<NavigationItem> navigationData = new ArrayList<>();

    @GetMapping
    public List<NavigationItem> getNavigation() {
        // 초기 데이터가 없으면 기본 값을 추가
        if (navigationData.isEmpty()) {
            navigationData.add(new NavigationItem("会社概要", List.of("会社紹介", "CEO紹介", "アクセス")));
            navigationData.add(new NavigationItem("サービス", List.of("サービス1", "サービス2")));
        }
        return navigationData;
    }

    @PostMapping
    public void saveNavigation(@RequestBody List<NavigationItem> navItems) {
        navigationData.clear();
        navigationData.addAll(navItems);
    }
}
