
## xml操作
![Dom4j的SAXReader类](imgs/xml.PNG)

- 1.引入两个jar:dom4j,jaxen
- 2.dom解析:xml一次性将整个xml文档加载进入内存中，
然后构建一棵Document的对象树，
能过Document得到树上的节点对象，通过节点对象操作到xml文档的内容，
所以缺点就是xml不能过大
    
