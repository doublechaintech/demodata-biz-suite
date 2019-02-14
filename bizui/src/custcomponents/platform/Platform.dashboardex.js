/*
把以下代码贴到customindex.js里面去
import PlatformDashboard from './platform/Platform.dashboardex';
import PlatformBizApp from './platform/Platform.appex';

在customindex增加的esult

const result = {
PlatformDashboard,
PlatformBizApp

};

*/

import PlatformDashboard from '../../bizcomponents/platform/Platform.dashboard'
import { List, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'
import numeral from 'numeral'
import FontAwesome from 'react-fontawesome'
import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './Platform.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
import appLocaleName from '../../common/Locale.tool'
const { TabPane } = Tabs

const topColResponsiveProps = {
  xs: 8,
  sm: 6,
  md: 6,
  lg: 4,
  xl: 4,
  style: { marginBottom: 24 },
}

const renderExtraHeader = platform => {
  const targetId = platform.id
  const functions=[
    {name:'借书',link:`/platform/${targetId}/about/1`,icon:"download"},
    {name:'还书',link:`/platform/${targetId}/about/2`,icon:"upload"},
    {name:'上架',link:`/platform/${targetId}/about/3`,icon:"arrow-up"},
    {name:'下架',link:`/platform/${targetId}/about/4`,icon:"arrow-down"},
    {name:'入库',link:`/platform/${targetId}/about/5`,icon:"login"},
    {name:'转入',link:`/platform/${targetId}/about/6`,icon:"menu-unfold"},
    {name:'出库',link:`/platform/${targetId}/about/7`,icon:"logout"},
    {name:'盘点',link:`/platform/${targetId}/about/8`,icon:"calculator"}

  ];

  return (

    <List
    grid={{ gutter: 16, xs: 1, sm: 2, md: 4, lg: 6, xl: 8, xxl: 12 }}
    dataSource={functions}
    renderItem={item => (
      <List.Item>
        <Card title={item.name}><Link to={item.link}>
        
        <Icon type={item.icon} style={{ fontSize: 50, color: '#08c' }}/>
        
        
       
       </Link></Card>
      </List.Item>
    )}
  />



   
  )
};


const panesData =[

  {name:'图书管理',subItems:["lossAssessmentRecordList","bookCopyList",
  "bookCopyTransferListAsOriginalStore","bookCopyTransferListAsNewStore",
  "bookCopyOperationRecordList","borrowingHistoryListAsLendingStore",
  "borrowingHistoryListAsReturnStore","bookCopySharingApplicationList"]},
  {name:'推广中心',subItems:["campaignList","storeSlideList"]},
  {name:'经营成果中心',subItems:["memberServiceRevenueList",
  "customerList","storeAccountList","borrowingExpiredSkuListAsLendingStore","borrowingExpiredSkuListAsReturnStore"]},
  {name:'店内设备',subItems:["printerList"]},
  {name:'店内工作人员',subItems:["employeeWorkingStoreList"]},

]

const subListWithPans = (cardsData,tabbedPaneData) => {
  const {id} = cardsData.cardsSource;
  return (<Row gutter={12}>

    <Tabs  size="large" tabBarStyle={{ marginBottom: 24 }}>

    {
      tabbedPaneData.map((paneItem)=>{return(
        <TabPane tab={paneItem.name} key={paneItem.name} >
        {
          paneItem.subItems.map(paneItemSubitem=>{
            
            return cardsData.subItems.filter(item=>item.name==paneItemSubitem).map(item=>{
             
              return(

                <Col {...topColResponsiveProps} key={item.name}>   
                <Badge count={item.count} style={{ backgroundColor: '#52c41a' }} overflowCount={9999999999}>        
                 <Card title={`${item.displayName}(${numeral(item.count).format('0,0')})`}  style={{ width: 180 }}>             
                   <p>

                     <Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}><FontAwesome name="list"  />&nbsp;管理</Link>
              {item.addFunction&&(<Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}><span className={styles.splitLine}></span><FontAwesome name="plus"  />&nbsp;新增</Link>)}   
               </p>        
               </Card> </Badge>
                 </Col>)

            })

          })

        }
        </TabPane>)
      })

    }
           
            </Tabs>
        </Row>)

}
const subListsOf = (cardsData) =>{

	return subListWithPans(cardsData,panesData)
}


class PlatformDashboardEx extends Component {

  render() {
    return (<PlatformDashboard renderExtraHeader={renderExtraHeader}/>)
  }


}

export default connect(state => ({
  platform: state._platform,
}))(PlatformDashboardEx)



/*

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Platform.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

