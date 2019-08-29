//JavaScript
var xhr;    //XMLHttpRequest对象
window.onload=function(){
    var selPro=$("selPro");
    var selCity=$("selCity");
    var selArea=$("selArea");

    //初次加载
    createXMLObject();  //创建XMLHttpRequest对象
    doProAjax(false);
    doCityAjax(selPro.value,false);
    doAreaAjax(selCity.value,false)
    
    selPro.onchange=function(){
        doCityAjax(this.value,false);
        doAreaAjax(selCity.value,false);
    }
    selCity.onchange=function(){
        doAreaAjax(this.value,true);
    }
}

//创建一个XMLRequest对象
var createXMLObject=function(){
    if(window.XMLHttpRequest){
        xhr=new XMLHttpRequest();
    }
    else{
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
    }
}


var doCityAjax=function(proCode,synFlag){
    xhr.open("Get","servlet/CityServlet?proCode="+proCode, synFlag,"admin","admin");
    xhr.onreadystatechange=getCity;
    xhr.send(null);
}

var doProAjax=function(synFlag){
	var url="servlet/ProvinceServlet";//post 
    xhr.open("Get",url, synFlag,"admin","admin"); 
    xhr.onreadystatechange=getProvince;
    xhr.send(null);
    
}

var doAreaAjax=function(cityCode,synFlag){
	 
    xhr.open("Get","servlet/AreaServlet?cityCode="+cityCode, synFlag,"admin","admin");
    xhr.onreadystatechange=getArea;
    xhr.send(null);
}


//sel:option组件名  tag:自定义标签
var getPlaceName=function(sel,tag){
    if(xhr.readyState==4 && xhr.status==200){
      var xml=xhr.responseXML;  
      sel.innerHTML="";
      //解析XML
      var provinces=xml.getElementsByTagName(tag);
      
      for(var i=0;i<provinces.length;i++){
          var tmp=provinces[i];
        //获取相关节点的信息
        var code=tmp.childNodes[0].textContent;
        var name=tmp.childNodes[1].textContent;
        var op=document.createElement("option");
          op.setAttribute("value",code);
        op.innerHTML=name;
        sel.appendChild(op);
      }
    }

}

var getProvince=function(){
    getPlaceName(selPro,"province");
}

var getCity=function(){
    getPlaceName(selCity,"city");
}

var getArea=function(){
    getPlaceName(selArea,"area");
}

/*通过Id获取相对应的组件*/
var $=function(id){
    return document.getElementById(id);
}

