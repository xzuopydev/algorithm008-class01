# Android 的缓存技术

一个优秀的应用首先它的用户体验是优秀的，在 Android 应用中恰当的使用缓存技术不仅
可以缓解服务器压力还可以优化用户的使用体验，减少用户流量的使用。在 Android 中缓存分为内存缓存和磁盘缓存两种：

## 内存缓存

读取速度快
可分配空间小
有被系统回收风险
应用退出就没有了，无法做到离线缓存


## 磁盘缓存
读取速度比内存缓存慢
可分配空间较大
不会因为系统内存紧张而被系统回收
退出应用缓存仍然存在（缓存在应用对应的磁盘目录中卸载时会一同清理，缓存在其他位置卸载会有残留）


### DiskLruCache
DiskLruCache 是 JakeWharton 大神在 github 上的一个开源库，代码量并不多。
与谷歌官方的内存缓存策略LruCache 相对应，DiskLruCache 也遵从于 LRU（Least recently used 最近最少使用）算法，
只不过存储位置在磁盘上。虽然在谷歌的文档中有提到但 DiskLruCache 并未集成到官方的 API中，
使用的话按照 github 库中的方式集成就行。DiskLruCache 使用时需要注意：

1. 每一条缓存都有一个 String 类型的 key 与之对应，每一个 key 中的值都必须满足 [a-z0-9_-]{1,120}的规则即数字大小写字母长度在1-120之间，所以推荐将字符串譬如图片的 url 等进行 MD5 加密后作为 key。
2. DiskLruCache 的数据是缓存在文件系统的某一目录中的，这个目录必须是唯一对应某一条缓存的，缓存可能会重写和删除目录中的文件。多个进程同一时间使用同一个缓存目录会出错。
3. DiskLruCache 遵从 LRU 算法，当缓存数据达到设定的极限值时将会后台自动按照 LRU 算法移除缓存直到满足存下新的缓存不超过极限值。
4. 一条缓存记录一次只能有一个 editor ，如果值不可编辑将会返回一个空值。
5. 当一条缓存创建时，应该提供完整的值，如果是空值的话使用占位符代替。
6. 如果文件从文件系统中丢失，相应的条目将从缓存中删除。如果写入缓存值时出错，编辑将失败。

DiskLruCache 不同于LruCache，LruCache是将数据缓存到内存中去，而DiskLruCache是外部缓存，
例如可以将网络下载的图片永久的缓存到手机外部存储中去，并可以将缓存数据取出来使用，
DiskLruCache不是google官方所写，但是得到了官方推荐，DiskLruCache没有编写到SDK中去，
如需使用可直接copy这个类到项目中去。

### 如何使用DiskLruCache：
1. 因为要操作外部存储，所以必须要先加上权限：
2. DiskLruCache是在外部存储上(如SD卡)，所以首先判断外部存储是否存在：
3. 根据URL下载一个在线图片并把它写到输出流outputstream中：
4. 上面已经下载了图片，接着初始化DiskLruCache，并使用DiskLruCache.Editor准备缓存：
5. 通过diskLruCache.get(key)得到DiskLruCache.Snapshot，key是经过MD5加密后那个唯一的key，
接着使用Snapshot.getInputStream()可以得到输入流InputStream ，进而得到缓存图片：
