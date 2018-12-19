package com.baizhi.action;

import com.baizhi.util.CreateValidateCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@Scope("prototype")
@RequestMapping("/CreateVcodeController")
public class CreateVcodeController {

    @RequestMapping("/getVcode")
    public void create(HttpSession session, HttpServletResponse response) throws IOException {
        //1.�������߶��󣬲�������֤��
        CreateValidateCode vCode = new CreateValidateCode(100, 30, 4, 10);

        //2.������Session������
        session.setAttribute("code", vCode.getCode());

        //3.ʹ��response���ָ��ͻ��˵������󣬲����
        vCode.write(response.getOutputStream());
    }
}
