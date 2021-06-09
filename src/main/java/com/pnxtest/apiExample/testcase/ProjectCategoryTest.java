package com.pnxtest.apiExample.testcase;

import com.pnxtest.core.api.Controller;
import com.pnxtest.core.api.DisplayName;
import com.pnxtest.core.api.Test;
import com.pnxtest.core.assertions.PnxAssert;
import com.pnxtest.http.PnxHttp;
import com.pnxtest.http.api.HttpResponse;

@Controller(module = "项目模块", maintainer = "陈鹏")
public class ProjectCategoryTest {
    @Test
    @DisplayName("获取指定项目下的所有分类列别，树形结构")
    void projectCategoryListingTest(){
        HttpResponse<String> response = PnxHttp.get("/api/v1/tms/{programId}/testCategory/")
                .routeParam("programId", "1")
                .asString();

        PnxAssert.assertThat(response.getStatus())
                .as("非法token请求")
                .isEqualTo(401);
    }

}
