定项

业务流程：
1、用户可通过本系统实现对数据库管理系统软件的管理与维护；
2、通过可视化页面操作实现sql基本语句的增删改查；
3、附加功能：可视化函数、计算、存储过程等的实现；

参与者：DBA

详细设计：
1、功能：增、删、改、查
2、前端：基本无要求，可实现即可
3、类：
实体类：用户（user可选）：
操作类（operation）：o_id,o_name,o_desc,o_func
表内部类（intable）：it_id,it_name，it_desc，t_name
功能类：controller、service、mapper




敏捷开发



类：
*u_user:u_id,u_account,u_password,u_ip
*r_right:r_id,r_name,r_desc,**u_id**(user)
d_database:     **u_id**(user)
t_table :**d_id**(database),**u_id**(user)
dts_table   :**t_id**(table),dts_id,dts_name,dts_content

v_view:d_id

f_function:d_id

s_squery:d_id

