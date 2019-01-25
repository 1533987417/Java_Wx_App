package com.example.demo2.entitysec;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRes extends JpaRepository<User,Long> {
    @Query(nativeQuery = true,value = "select distinct 学院名 as college from 人员 where 学院名 like '%学院'")
    List GetCollege(Long gzh);
    @Query(nativeQuery = true,value = "select 工资号 as gzh,姓名 as xm,职称 as zc,头像 as headimg,bxy as role from 人员 where 学院名 like '%'+?1+'%' and charindex(职称,'教授,研究员,副教授,讲师') > 0 order by charindex(职称,'教授,研究员,副教授,讲师')")
    List GetCollegeMember(String college);
    @Query(nativeQuery = true,value = "select * from 人员 where 工资号=?1")
    List getGetProfile(String gzh);

   // @Query(nativeQuery = true,value = "sele")

    //绑定验证by gzh ,password
    @Query(nativeQuery = true,value = "select 工资号,姓名,学院码,学院名,头像,(SELECT  MAX(roleclassid) FROM Tb_RolesAndNavigation WHERE rolesid IN(SELECT 0 UNION               SELECT rolesid FROM Tb_RolesAddUser               WHERE UserId=?1)) as bxy from 人员 with(nolock) where 工资号=?2 AND 密码=?3")
    User verify(Long gzh,Long gzh1,String password);

    //通过gzh查询信息
    @Query(nativeQuery = true,value = "select 工资号,姓名,学院码,学院名,头像,(SELECT  MAX(roleclassid) FROM Tb_RolesAndNavigation        WHERE rolesid IN(SELECT 0 UNION        SELECT rolesid FROM Tb_RolesAddUser      WHERE UserId=?1)) as bxy from 人员 with(nolock) where 工资号=?2")
     User query(Long gzh,Long gzh1);

    //发表论文
    @Query(nativeQuery = true,value = "select id,[论文名称],[发表刊物],[发表时间] from VIEW_paper_tag  where id in(select paper_id from view_paper_js where gzh =?1)")
    List getGetResearch(Long gzh);
   //著作查询
    @Query(nativeQuery = true,value="select id,著作名称,出版单位,类别, 年度,bhide from book where 工资号 =?1")
    List getZhuzuo(Long gzh);
    //纵向项目
    @Query(nativeQuery =true,value = "select id,项目名称,项目来源,起年限,项目性质,bhide,止年限,总经费 from 项目 where 项目类别='纵向' and 工资号 =?1")
    List getzongxiang(Long gzh);

    //横向项目
    @Query(nativeQuery =true,value = "select id,项目名称,项目来源,起年限,项目性质,bhide,止年限,总经费,合作单位 from 项目 where 项目类别='横向' and 工资号 =?1")
    List gethengxiang(Long gzh);

    //专利
    @Query(nativeQuery =true,value ="select id,专利名称, 专利类型,授权日期,bhide from 专利 where 工资号 =?1")
    List getzhuanli(Long gzh);

    //软件著作权
    @Query(nativeQuery =true,value ="select id,软件名称, 年度,bhide from 软件著作权  where 工资号=?1")
    List getrjzz(Long gzh);

    //动物品种

    @Query(nativeQuery =true,value =" select 新品种名称,发证时间,发证机关 from 动物品种  where 工资号=?1")
    List getdongwu(Long gzh);

    //植物品种
    @Query(nativeQuery =true,value ="select 作物名称,品种名称,通过审定时间,主持审定单位  from 植物品种  where 工资号=?1")
    List getzhiwu(Long gzh);

    //植物品种权
    @Query(nativeQuery =true,value ="select 属或者种,品种名称,发证时间,培育人 from 植物品种权  where 工资号=?1")
    List getzhiwupz(Long gzh);

    //报奖
    @Query(nativeQuery =true,value ="select 成果名称,奖种级别,奖种名称,获奖年份 from 报奖  where 工资号=?1")
    List getReward(Long gzh);

    //标准
    @Query(nativeQuery =true,value ="select id,标准名称,标准编号,发布时间 from 标准  where 工资号=?1")
    List getstandard(Long gzh);

    //其他成果
    @Query(nativeQuery =true,value ="select id,成果名称,成果类型,发证时间,证号 from 其他成果  where 工资号=?1")
    List getother(Long gzh);






}
