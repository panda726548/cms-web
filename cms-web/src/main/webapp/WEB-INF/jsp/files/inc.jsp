<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
当前栏目:${pc.name }[${pc.id }]&nbsp;
<a href="<%=request.getContextPath() %>/admin/file/files/${pid}" class="admin_link">子栏目列表</a>
</span>