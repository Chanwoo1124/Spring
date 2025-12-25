package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class SessionMangerTest {

    SessionManger sessionManger = new SessionManger();

    @Test
    void createSession() {

        //세션 생성
        HttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManger.createSession(member, response);

        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies();
    }

    @Test
    void getSession() {
    }

    @Test
    void expire() {
    }

    @Test
    void findCookie() {
    }
}