/**
 * 初始化房屋管理详情对话框
 */
var HouseManagerInfoDlg = {
    houseManagerInfoData : {}
};

/**
 * 清除数据
 */
HouseManagerInfoDlg.clearData = function() {
    this.houseManagerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HouseManagerInfoDlg.set = function(key, val) {
    this.houseManagerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HouseManagerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
HouseManagerInfoDlg.close = function() {
    parent.layer.close(window.parent.HouseManager.layerIndex);
}

/**
 * 收集数据
 */
HouseManagerInfoDlg.collectData = function() {
    this
    .set('uuid')
    .set('houseUser')
    .set('houseArea')
    .set('houseAddress')
    .set('houseTime')
    .set('houseLoan')
    .set('houseDesc');
}

/**
 * 提交添加
 */
HouseManagerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/houseManager/add", function(data){
        Feng.success("添加成功!");
        window.parent.HouseManager.table.refresh();
        HouseManagerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.houseManagerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
HouseManagerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/houseManager/update", function(data){
        Feng.success("修改成功!");
        window.parent.HouseManager.table.refresh();
        HouseManagerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.houseManagerInfoData);
    ajax.start();
}

$(function() {

});
