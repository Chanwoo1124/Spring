package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class SessionMangerTest {

    private static final Logger log = LoggerFactory.getLogger(SessionMangerTest.class);
    SessionManger sessionManger = new SessionManger();

    @Test
    void createSession() {

        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManger.createSession(member, response);

        //요청에 응답 쿠키 저장 (웹브라우져 요청이라고 가정)
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        //세션 조회
        sessionManger.getSession(request);
        Object result = sessionManger.getSession(request);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member);

        //세션 만료
        sessionManger.expire(request);
        Object expired = sessionManger.getSession(request);
        org.assertj.core.api.Assertions.assertThat(expired).isNull();

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