package org.example.why_pstmt.model.dto;

import java.util.UUID;

public record TestUser(
        long id,
        String username,
        String password,
        String createdAt) {
}
