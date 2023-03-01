> buffer
``` java
ByteBuffer buffer = ByteBuffer.allocate(10);
System.out.println((char) buffer.get());
buffer.put(new byte[]{'a','b','c','d'});
Buffer position() 缓冲取当前位置
Buffer limit() 可读字符的 长度
Buffer rewind() 不改变极限，把位置设置为0，表示从头开始读取 取消mark。
Buffer mark() 将此缓冲区的标记设置在其位置。
Buffer reset() 将此缓冲区的位置重置为先前标记的位置。
Buffer clear() clear会从头开始的
```
> limit 
``` java
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String n = "absdaeras";
        buffer.put(n.getBytes());
        buffer.flip();
        byte[] b= new byte[2];
        buffer.get(b);
        String rs=new String(b);
        System.out.println(rs); // ab
        System.out.println(buffer.position()); // 2
        System.out.println(buffer.limit()); // 9
        System.out.println(buffer.capacity());// 10
```
> transferFrom transferFromTo 通道转移，数据转移
``` java
  FileInputStream isFile = new FileInputStream("/Users/xuyang/Documents/java/RabbitMQ/demo1/src/main/java/org/example/io/nio/a.txt");
        FileChannel isChannel=isFile.getChannel();
        FileOutputStream outFile=new FileOutputStream("/Users/xuyang/Documents/java/RabbitMQ/demo1/src/main/java/org/example/io/nio/b.txt");
        FileChannel outChannel=outFile.getChannel();
//        outChannel.transferFrom(isChannel,isChannel.position(),isChannel.size());
        isChannel.transferTo(isChannel.position(),isChannel.size(),outChannel);
        isChannel.close();
        outChannel.close();
```
> selector 