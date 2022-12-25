//package com.axonactive.coffeemanagement;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import com.axonactive.coffeemanagement.dao.MemberDao;
//import com.axonactive.coffeemanagement.entity.Member;
//import com.axonactive.coffeemanagement.service.mapper.MemberMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//
//import com.axonactive.coffeemanagement.service.MemberService;
//import com.axonactive.coffeemanagement.service.dto.MemberDto;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.inject.Inject;
//
//
//@ExtendWith(MockitoExtension.class)
//public class MemberServiceTest {
//    @Mock
//    private MemberService memberService;
//
////    @BeforeEach
////    public void setUp(){
////        MockitoAnnotations.initMocks(this);
////    }
//
//    @Test
//    public void testFindMemberByPhone(){
//        String phone = "037647365";
//        MemberDto expected = new MemberDto("037647365","Member 1",0);
////        when(memberService.findById(3L)).thenReturn(expected);
//        MemberDto actual = memberService.findById(3L);
//        System.out.println(actual.getName());
////        assertEquals(expected,actual);
//    }
//}
