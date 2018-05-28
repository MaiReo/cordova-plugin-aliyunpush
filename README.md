# cordova-plugin-aliyunpush

## Install

> 注意：
> - 应用的包名一定要和 APP_KEY 对应应用的包名一致，否则推送服务无法注册成功。
> - 在使用 8 或以上版本的 Xcode 调试 iOS 项目时，需要先在项目配置界面的 Capabilities 中打开 Push Notifications 开关。
> - ANDROID_KEY:对应的android key
> - ANDROID_SECRET:ANDROID SECRET
> - IOS_KEY:ios key
> - IOS_SECRET:ios SECRET

- 通过 Cordova Plugins 安装，要求 Cordova CLI 5.0+：

  ```shell
  cordova plugin add cordova-plugin-aliyunpush --variable ANDROID_KEY=${ANDROID_KEY} --variable ANDROID_SECRET=${ANDROID_SECRET} --variable IOS_KEY=${IOS_KEY} --variable IOS_SECRET=${IOS_SECRET}
  ```

- 或下载到本地安装：

  ```shell
  cordova plugin add Your_Plugin_Path --variable ANDROID_KEY=${ANDROID_KEY} --variable ANDROID_SECRET=${ANDROID_SECRET} --variable IOS_KEY=${IOS_KEY} --variable IOS_SECRET=${IOS_SECRET}
  ```


## Usage

### API

```javascript
    /**
     * 获取设备唯一标识deviceId，deviceId为阿里云移动推送过程中对设备的唯一标识（并不是设备UUID/UDID）
     * @param  {Function} successCallback 成功回调
     * @param  {Function} errorCallback   失败回调
     * @return {void}  
     */
    getRegisterId: function(successCallback, errorCallback)

    /**
     * 阿里云推送绑定账号名
     * @param  {string} account         账号
     * @param  {Function} successCallback 成功回调
     * @param  {Function} errorCallback   失败回调
     * @return {void} 
     */
    bindAccount: function(account, successCallback, errorCallback) 

    /**
     * 阿里云推送绑定标签
     * @param  {string[]} tags            标签列表
     * @param  {Function} successCallback 成功回调
     * @param  {Function} errorCallback   失败回调
     * @return {void}  
     */
    bindTags: function(tags, successCallback, errorCallback) 

    /**
     * 阿里云推送解除绑定标签
     * @param  {string[]} tags            标签列表
     * @param  {Function} successCallback 成功回调
     * @param  {Function} errorCallback   失败回调
     * @return {void}               
     */
    unbindTags: function(tags, successCallback, errorCallback)

    /**
     * 阿里云推送解除绑定标签
     * @param  {Function} successCallback 成功回调
     * @param  {Function} errorCallback   失败回调
     * @return {void}           
     */
    listTags: function(successCallback, errorCallback) 


  /**
   * 阿里云推送消息透传回调
   * @param  {Function} successCallback 成功回调
   */
  onMessage(sucessCallback) ;

  # sucessCallback:调用成功回调方法，注意没有失败的回调，返回值结构如下：
    #json: {
      type:string 消息类型,
      title:string '阿里云推送',
      content:string '推送的内容',
      extra:string | Object<k,v> 外健,
      url:路由
    }

    #消息类型
    {
      message:透传消息，
      notification:通知接收，
      notificationOpened:通知点击，
      notificationReceived：通知到达，
      notificationRemoved：通知移除，
      notificationClickedWithNoAction：通知到达，
      notificationReceivedInApp：通知到达打开 app
    }
	/**
     * 创建通知频道（安卓
     * @param  {string} channelId          通知频道Id
	 * @param  {string} channelName        通知频道名称
	 * @param  {string} channelDescription 通知频道描述
     * @param  {Function} successCallback  成功回调
     * @param  {Function} errorCallback    失败回调
     * @return {void}               
     */
	createNotificationChannel: function(channelId, channelName, channelDescription, successCallback, errorCallback)
```


