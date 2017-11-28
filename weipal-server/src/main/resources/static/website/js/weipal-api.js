/**
 * api
 * @author shicheng
 */
var WeipalApi = {

    /* formatter */
    formatSQL: WeipalCommon.getApi() + '/api/v1/formatter/sql/format',

    getSourceById: WeipalCommon.getApi() + '/api/v1/datasource/get/uid',

    getCatalog: WeipalCommon.getApi() + '/api/v1/presto/query/catalog',

}