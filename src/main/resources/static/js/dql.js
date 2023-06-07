function selectUserList() {
    $.ajax({
        type:"get",
        url:"/dql/selectUserList",
        async:false,

        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped' ><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>账号</th>" +
                    "<th scope='col'>密码</th>" +
                    "<th scope='col'>IP</th>" +
                    "<th scope='col'>手机号</th>" +
                    "<th scope='col'>邮箱</th></tr></thead></table>").appendTo($(".userList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.uid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.uaccount + "</td>").appendTo(tr);
                    var td3 = $("<td>" + value.upassword + "</td>").appendTo(tr);
                    var td4 = $("<td>" + value.uhost + "</td>").appendTo(tr);
                    var td5 = $("<td>" + value.utel + "</td>").appendTo(tr);
                    var td6 = $("<td>" + value.uemail + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectDBList() {
    $.ajax({
        type:"get",
        url:"/dql/selectDBList",
        async:false,

        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped' ><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>数据库名</th>" +
                    "<th scope='col'>字符集</th>" +
                    "</tr></thead></table>").appendTo($(".dbList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.did + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.dname + "</td>").appendTo(tr);
                    var td3 = $("<td>" + value.dcharset + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectTableList() {
    $.ajax({
        type:"get",
        url:"/dql/selectTableList",
        async:false,

        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped' ><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>表名</th>" +
                    "<th scope='col'>表描述</th>" +
                    "</tr></thead></table>").appendTo($(".tableList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.tid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.tname + "</td>").appendTo(tr);
                    var td3 = $("<td>" + value.tdesc + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectQueryList() {
    $.ajax({
        type:"get",
        url:"/dql/selectQueryList",
        async:false,
        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped'><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>查询名</th>" +
                    "</tr></thead></table>").appendTo($(".queryList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.qid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.qname + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectFunList() {
    $.ajax({
        type:"get",
        url:"/dql/selectFunList",
        async:false,
        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped'><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>函数名</th>" +
                    "</tr></thead></table>").appendTo($(".funList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.fid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.fname + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}
function selectRightList() {
    $.ajax({
        type:"get",
        url:"/dql/selectRightList",
        async:false,
        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped'><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>权限名</th>" +
                    "<th scope='col'>描述</th>" +
                    "</tr></thead></table>").appendTo($(".rightList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.rid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.rname + "</td>").appendTo(tr);
                    var td3 = $("<td>" + value.rdesc + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectViewList() {
    $.ajax({
        type:"get",
        url:"/dql/selectViewList",
        async:false,
        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped'><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>视图名</th>" +

                    "</tr></thead></table>").appendTo($(".viewList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.vid + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.vname + "</td>").appendTo(tr);

                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}

function selectTableFieldList() {
    $.ajax({
        type:"get",
        url:"/dql/selectTableFieldList",
        async:false,
        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table table-striped'><thead class='thead-dark'>" +
                    "<tr><th scope='col'>ID</th>" +
                    "<th scope='col'>字段名</th>" +
                    "<th scope='col'>类型</th>" +
                    "<th scope='col'>约束</th>" +

                    "</tr></thead></table>").appendTo($(".tableFieldList"));
                for(var key in data){
                    var value = data[key];
                    console.log(value);
                    //表格细节
                    var tr = $("<tr></tr>").appendTo(table);
                    var td1 = $("<td>" + value.tfId + "</td>").appendTo(tr);
                    var td2 = $("<td>" + value.fieldName + "</td>").appendTo(tr);
                    var td3 = $("<td>" + value.fieldType + "</td>").appendTo(tr);
                    var td4 = $("<td>" + value.fieldConstraint + "</td>").appendTo(tr);
                }
            }else{
                console.log("query null");
            }
        },
        error:() =>{alert("Error!");}
    })
}