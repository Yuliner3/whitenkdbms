function selectUserList() {
    $.ajax({
        type:"get",
        url:"/dql/selectUserList",
        async:false,

        success:(data) =>{
            if(data != null){
                //创建表格
                var table = $("<table class='table' ><thead class='thead-dark'>" +
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
                var table = $("<table class='table' ><thead class='thead-dark'>" +
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
                var table = $("<table class='table' ><thead class='thead-dark'>" +
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