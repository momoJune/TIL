<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var max = 10, min = 2, count = 2;
	function addFile(){
		if(count==max){
			alert('최대 ' + max + "만 첨부 가능합니다.");
			return;
		}
		// 태그 추가
		++count;
		// div태그 만들고 속성 추가
		var divTag = document.createElement("div");
		divTag.id = "file"+count;
		// 텍스트노드 만들고 div태그에 추가
		var textNode = document.createTextNode("파일 " + (count<10 ? "0"+count : count) + " : ");
		divTag.appendChild(textNode);
		// input 태그 만들고 div태그에 추가
		var inputTag = document.createElement("input");
		inputTag.type="file";
		inputTag.name="file";
		divTag.appendChild(inputTag);
		// div태그를 filebox에 추가
		document.getElementById("filebox").appendChild(divTag);
	}
	function removeFile(){
		if(count==min){
			alert('최소 ' + min + "개는 첨부 해야합니다.");
			return;
		}
		// 태그 제거
		var removeTag = document.getElementById("file"+count);
		document.getElementById("filebox").removeChild(removeTag);
		--count;
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<h2>첨부파일</h2>
	<button onclick="addFile()"> + </button>
	<button onclick="removeFile()"> - </button>
	<br /><hr />
	<div id="filebox">
		<div id="file1">
			파일 01 : <input type="file" name="file" />
		</div>
		<div id="file2">
			파일 02 : <input type="file" name="file" />
		</div>
	</div>
</body>
</html>