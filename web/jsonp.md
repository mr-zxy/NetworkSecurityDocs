# jsonp 代码
> 因为浏览器的同源策略导致接口无法通过浏览器访问。jsonp是一种古老的解决方法。原理就是利用 script 标签。请求资源。
* script 标签不存在跨域问题
* 可以理解成 引用cdn连接一样  
``` js
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script>console.log($)</script>
—————————————————————————————————————————————————————————————————
这样就可以拿到jq的实例了。
```

``` java
    @GetMapping("/helloTest3"
    public String helloTest2(){
        String jsonCallback = "jsonCallback";
        String return_JSONP = "10";
        return_JSONP = jsonCallback + "(" + return_JSONP  + ");";
        return return_JSONP;
    }
```
```js
   <script>
    function jsonCallback(id) {
        alert(id)
    }
    </script>
    <script src="http://192.168.1.52:8080/helloTest3"></script>
```