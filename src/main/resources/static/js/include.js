function getIds(grid,key) {
    let ids=[];
    let rows = grid.datagrid('getSelections');
    for (var i=0;i<rows.length;i++){
        ids.push(rows[i][key]);
    }
    return ids.join(",");
}
