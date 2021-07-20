package com.maccura;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestFulPlyApplication.class)
@AutoConfigureMockMvc
/**
 *  springboot 2.2.0开始引入Junit5作为单元测试的默认库
 *  Junit5 = JUnit Platform+ JUnit Jupiter+JUnit Vintager,springboot2.4移除了Vintager
 *  Junit4   -          Junit5                  说明
 *  @Test               @Test                   表示一个测试方法,5与4的注解不同，没有声明任何属性
 *  @BeforeClass        @BeforeAll              该注解的方法应该在该类所以使用@Test,@RepeatedTest,@ParameterizedTest或者@TestFactory注解方法执行前执行。
 *  @AfterClass         @AfterAll               该注解的方法应该在该类所以使用@Test,@RepeatedTest,@ParameterizedTest或者@TestFactory注解方法执行后执行。
 *  @Before             @BeforeEach             该注解的方法应该在该类每一个使用@Test,@RepeatedTest,@ParameterizedTest或者@TestFactory注解方法执行前执行。
 *  @After              @AfterEach              该注解的方法应该在该类每一个使用@Test,@RepeatedTest,@ParameterizedTest或者@TestFactory注解方法执行后执行。
 *  @Ignore             @Disabled               禁用一个测试类或方法
 *  @Caetgroy           @Tag                    用于声明过滤测试的tags,该注解用于方法或类上
 *  @Parameterized      @ParameterizedTest       参数化测试
 *  @RunWith            @ExtentWith             确定类的运行方式
 *  @Rule               @ExtentWith             验证,监视TestCase和外部资源管理等能力
 *  @ClassRule          @ExtentWith             @ClassRule 静态变量,必须是TestRule的实例,public修饰。
 */
class RestFulPlyApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
 // 组合 产品  getGlobalDescribe
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        System.out.println("<------>");
    }

    /**
     * @throws Exception e
     *                   RepeatedTest(3) 重复测试次数
     *                   Timeout 超时时间
     */
    @RepeatedTest(3)
    @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS)
    void contextLoads() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/restFul/ply/add/ztt").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
