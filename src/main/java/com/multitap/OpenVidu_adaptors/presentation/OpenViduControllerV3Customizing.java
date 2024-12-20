//package com.multitap.OpenVidu_adaptors.presentation;
//
//import com.multitap.OpenVidu_adaptors.application.OpenViduService;
//import io.swagger.v3.oas.annotations.Operation;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@CrossOrigin(
//        origins = {"*"}
//)
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/openvidu")
//@Slf4j
//public class OpenViduControllerV3Customizing {
//
//    private final OpenViduService openViduService;
//
//    @GetMapping("/")
//    public Map<String, String> hello() {
//        return Map.of("message", "Welcome to the OpenVidu Application!");
//    }
//
//    // 세션에서 토큰 생성
//    @Operation(summary = "토큰 발행", description = "memberSessionUuid와 userUuid로 토큰을 발행합니다.")
//    @PostMapping("/generate-token")
//    public ResponseEntity<Map<String, String>> generateToken(
//            @RequestHeader ("userUuid") String userUuid,
//            @RequestParam String mentoringSessionUuid) {
//        log.info("generateToken: userUuid={}, mentoringSessionUuid={}", userUuid, mentoringSessionUuid);
//        try {
//            String token = openViduService.generateToken(mentoringSessionUuid, userUuid);
//            return ResponseEntity.ok(Map.of("token", token));
//        } catch (IllegalArgumentException e) {
//            log.error("Error generating OpenVidu token", e);
//            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
//        }
//    }
//
//    @PostMapping(value = "/livekit/webhook", consumes = "application/webhook+json")
//    public ResponseEntity<String> receiveWebhook(
//            @RequestHeader("Authorization") String authHeader,
//            @RequestBody String body) {
//        try {
//            openViduService.receiveWebhook(authHeader, body);
//            return ResponseEntity.ok("ok");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(400).body(e.getMessage());
//        }
//    }
//}
