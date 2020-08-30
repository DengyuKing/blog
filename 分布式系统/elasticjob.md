# Elastic job

## 数据分片
分片的概念是把一个任务分为多少个子任务，和集群中机器的数量是没有关系的，例如，在一个集群中有2台机器，一个任务分成两个分片，则可以根据规则设置每个机器执行一个分片。如果是分成了N个分片，可以根据规则，让其中的一个机器执行i个分片，另一个机器执行N-i个分片。

## zk
elasticjob使用了ZK，它主要用zk存了什么东西呢？
第一个是存储了job信息
第二个是存储了主从信息
第三个是存储了触发时间


job存储

JobNodeStorage {
 registry
 jobName
 jobNodePath
}

JobNodePath{


}

JobScheduler 启动类