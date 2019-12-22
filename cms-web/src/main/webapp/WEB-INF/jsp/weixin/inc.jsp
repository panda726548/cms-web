<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
<a href="<%=request.getContextPath() %>/admin/weixinMenu/add/${pid}" class="admin_link">添加菜单</a>
当前栏目:${pc.name }[${pc.id }]&nbsp;
<a href="<%=request.getContextPath() %>/admin/weixinMenu/weixinMenu/${pid}" class="admin_link">子菜单列表</a>
</span>