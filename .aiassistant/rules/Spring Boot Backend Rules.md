---
apply: always
---

Follow these project rules for this Java Spring Boot backend:

- Use layered architecture: controller -> service -> repository
- Keep controllers thin; no business logic in controllers
- Use DTOs for request/response; do not expose entities directly
- Use Bean Validation on incoming requests
- Use centralized exception handling with @RestControllerAdvice
- Return consistent API error responses
- Use constructor injection
- Use parameterized logging, never string concatenation
- Never log passwords, tokens, secrets, or sensitive personal data
- Prefer clear, maintainable code over clever abstractions
- Add or update tests when behavior changes
- Reuse existing project patterns and package conventions