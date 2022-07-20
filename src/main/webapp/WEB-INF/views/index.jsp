<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<c:forEach items="${listEmp }" var="listEmp"> --%>
	<%-- 		<input type="hidden" value="${listEmp.ename}" id="${listEmp.eno}"/> --%>
	<%-- 	</c:forEach> --%>

	<div id="tree" class="tui-tree-wrap"></div>
	<button id="addChildBtn">add</button>
	<button id="removeChildBtn">remove</button>
	<button id="sortBtn">sort</button>
</body>
<script src="https://uicdn.toast.com/tui-tree/latest/tui-tree.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui-tree/latest/tui-tree.css" />
<script
	src="https://uicdn.toast.com/tui.context-menu/v2.1.6/tui-context-menu.min.js"></script>
<script type="text/javascript">
	var util = {
		addEventListener : function(element, eventName, handler) {
			if (element.addEventListener) {
				element.addEventListener(eventName, handler, false);
			} else {
				element.attachEvent('on' + eventName, handler);
			}
		}
	};

	var data = [ {
		text : 'rootA',
		children : [ {
			text : 'sub-A1'
		}, {
			text : 'sub-A2'
		}, {
			text : 'sub-A3'
		}, {
			text : 'sub-A4'
		}, {
			text : 'sub-A5',
			state : 'closed',
			children : [ {
				text : 'sub-A5A',
				children : [ {
					text : 'sub-A5A1'
				} ]
			}, {
				text : 'sub_A5B'
			} ]
		}, {
			text : 'sub-A6'
		}, {
			text : 'sub-A7'
		}, {
			text : 'sub-A8'
		}, {
			text : 'sub-A9',
			state : 'opened',
			children : [ {
				text : 'sub-A9A'
			}, {
				text : 'sub-A9B'
			} ]
		}, {
			text : 'sub-A10'
		}, {
			text : 'sub-A11'
		}, {
			text : 'sub-A12'
		} ]
	}, {
		text : 'rootB',
		state : 'closed',
		children : [ {
			text : 'sub-B1'
		}, {
			text : 'sub-B2'
		}, {
			text : 'sub-B3'
		} ]
	} ];

	var movedValue = document.getElementById('movedValue');

	var tree = new tui.Tree('#tree', {
		data : data,
		nodeDefaultState : 'opened'
	}).enableFeature('Editable', {
		dataKey : 'text'
	}).enableFeature('Draggable', {
		helperClassName : 'tui-tree-drop',
		lineClassName : 'tui-tree-line',
		isSortable : true
	});
</script>
</html>
