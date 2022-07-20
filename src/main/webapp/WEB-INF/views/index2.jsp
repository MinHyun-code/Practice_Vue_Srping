<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<!-- grid -->
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<link rel="stylesheet"
	href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<!-- tree -->
<script src="https://uicdn.toast.com/tui-tree/latest/tui-tree.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui-tree/latest/tui-tree.css" />
<script
	src="https://uicdn.toast.com/tui.context-menu/v2.1.6/tui-context-menu.min.js"></script>

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="grid"></div>

	<div id="tree" class="tui-tree-wrap"></div>
	<button id="addChildBtn">add</button>
	<button id="removeChildBtn">remove</button>
	<button id="sortBtn">sort</button>


	<script type="text/javascript">

	var gridData = ${listEmp2};

const grid = new tui.Grid({
    el: document.getElementById('grid'),
    data: gridData,
    scrollX: false,
    scrollY: false,
    columns: [
      {
        header: 'eno',
        name: 'eno'
      },
      {
        header: 'ename',
        name: 'ename'
      },
      {
        header: 'id',
        name: 'id'
      },
      {
        header: 'pw',
        name: 'pw',
        editor: {
            type: 'radio',
            options: {
              listItems: [
                { text: 'Pop', value: '1' },
                { text: 'Rock', value: '2' },
                { text: 'R&B', value: '3' }
              ]
            }
          }
      },
      {
          header: '선택',
          name: '선택',
          editor: {
              type: 'radio',
              options: {
                listItems: [
                  { text: 'Pop', value: '1' },
                  { text: 'Rock', value: '2' },
                  { text: 'R&B', value: '3' }
                ]
              }
            }
      }
    ],
    draggable: true
  });
  
  
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
	
    var addChildBtn = document.getElementById('addChildBtn');
    var removeChildBtn = document.getElementById('removeChildBtn');
    var sortBtn = document.getElementById('sortBtn');
    var rootNodeId = tree.getRootNodeId();
    var firstChildId = tree.getChildIds(rootNodeId)[0];

    util.addEventListener(addChildBtn, 'click', function() {
        tree.add({text:'hello world'}, firstChildId);
    });

    util.addEventListener(removeChildBtn, 'click', function() {
        var lastGrandChildId = tree.getChildIds(firstChildId).slice(-1)[0];
        tree.remove(lastGrandChildId);
    });

    util.addEventListener(sortBtn, 'click', function() {
        tree.sort(function(nodeA, nodeB) {
            var aValue = nodeA.getData('text'),
                bValue = nodeB.getData('text');

            if (!aValue.localeCompare) {
                return 0;
            }
            return aValue.localeCompare(bValue);
        });
    });
</script>
</body>
</html>