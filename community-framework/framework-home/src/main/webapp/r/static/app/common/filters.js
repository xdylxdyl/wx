// 为了分割数组以便二次使用ng-repeat
// 通常需要的场景是你需要每隔N个元素插入分组节点
// 如果你修改items内部元素的属性 angular会自动watch更新
// 但如果动态增删items的元素，需要手动删除items.$rows，以便重新计算

app.filter('group', function () {
  return function (items, cols) {
    if (!items) {
      return items;
    }
    // if items be modified, delete cache
    if (items.$rows) {
      var temp = [];
      for (var i = 0; i < items.$rows.length; i++) {
        temp = temp.concat(items.$rows[i]);
      }

      if (temp.length !== items.length) {
        delete items.$rows;
      }
      else {
        for (var j = 0; j < items.length; j++) {
          if (items[j] !== temp[j]) {
            delete items.$rows;
            break;
          }
        }
      }
    }

    // cache rows for angular dirty check
    if (!items.$rows) {
      var rows = [];
      for (var k = 0; k < items.length; k++) {
        if (k % cols === 0) {
          rows.push([]);
        }
        rows[rows.length - 1].push(items[k]);
      }
      items.$rows = rows;
    }

    return items.$rows;
  };
});

// 判断是否是空白对象
app.filter('empty', function () {
  return function (obj) {
    return !obj || angular.equals({}, obj) || angular.equals([], obj);
  };
});