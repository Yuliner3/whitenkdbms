var flag = 0;
var field_name = [];
var field_type = [];
var field_length = [];
var if_null = [];
var if_key = [];
var field_desc = [];

function createTable() {
    var table_name = $("#tableName").val();
    field_name = new Array(flag);
    field_desc = new Array(flag);
    field_length = new Array(flag);
    if_null = new Array(flag);
    if_key = new Array(flag);
    field_type = new Array(flag);

    var fieldName = "";
    var fieldDesc = "";
    var fieldLength = "";
    var fieldType = "";
    var ifNull = "";
    var ifKey = "";

    for (var i = 0 ; i < flag; i ++){
        fieldName = "field_name" + i;
        fieldDesc = "field_desc" + i;
        fieldLength = "field_length" + i;
        fieldType = "field_type" + i;
        ifNull = "if_null" + i;
        ifKey = "if_key" + i;
        field_name[i] = $("#" + fieldName).val();
        field_desc[i] = $("#" + fieldDesc).val();
        field_length[i] = $("#" + fieldLength).val();
        field_type[i] = $("#" + fieldType).val();
        if_null[i] = $("#" + ifNull).prop("checked");
        if_key[i] = $("#" + ifKey).prop("checked");
    }

    //console.log(field_name);
    var dataList = {
        tableName:table_name,
        fieldName:field_name,
        fieldType:field_type,
        fieldLength:field_length,
        ifNull:if_null,
        ifKey:if_key,
        fieldDesc:field_desc
    }

    if(table_name == ""){
        alert("表名不能为空");
    }else {
        if (field_name.length == 0 || field_type.length == 0 || field_length.length == 0) {
            alert("字段名或类型或长度不能为空");
        } else {
            if (field_desc == false) {
                dataList.fieldDesc = "null";
            }
            $.ajax({
                type: "get",
                url: "/dml/createTable",
                async: false,
                data: dataList,
                success: (data) => {
                    console.log(data.toString());
                },
                error: () => {
                    alert("UnKnown Error");
                }
            })
        }
    }

}

function addField(){

    var table = $(".table");
    var tr = $("<tr></tr>").appendTo(table);
    var td1 = $("<td>" + "<input type='text' id='field_name" + flag + "' required='required'/>" + "</td>").appendTo(tr);
    var td2 = $("<td>" + "<input type='text' id='field_type" + flag + "' required='required'/>"+"</td>").appendTo(tr);
    var td3 = $("<td>" + "<input type='text' id='field_length" + flag + "' required='required'/>"+"</td>").appendTo(tr);
    var td4 = $("<td>" + "<input type='checkbox' id='if_null" + flag + "' />" + "</td>").appendTo(tr);
    var td5 = $("<td>" + "<input type='checkbox' id='if_key" + flag + "' />" + "</td>").appendTo(tr);
    var td6 = $("<td>" + "<input type='text' id='field_desc" + flag + "' />"+"</td>").appendTo(tr);

    $('#if_null').trigger("create");
    $('#if_key').trigger("create");
    flag ++;
}

function delTable(){
    var tableName = $("#delTable").val();
    var dataList = {
        tableName:tableName
    }
    $.ajax({
        type: "get",
        url: "/dml/deleteTable",
        async: false,
        data: dataList,
        success: (data) => {
            if(data){
                console.log("删除成功");
            }else{
                console.log("删除失败")
            }
        },
        error: () => {
            alert("UnKnown Error");
        }
    })
}
