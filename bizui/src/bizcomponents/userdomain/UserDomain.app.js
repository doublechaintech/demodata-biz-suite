import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './UserDomain.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class UserDomainBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/userDomain/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/userDomain/${this.props.userDomain.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/userDomain/${this.props.userDomain.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getUserWhiteListSearch = () => {
    const {UserWhiteListSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "User White List",
      role: "userWhiteList",
      data: state._userDomain.userWhiteListList,
      metaInfo: state._userDomain.userWhiteListListMetaInfo,
      count: state._userDomain.userWhiteListCount,
      currentPage: state._userDomain.userWhiteListCurrentPageNumber,
      searchFormParameters: state._userDomain.userWhiteListSearchFormParameters,
      searchParameters: {...state._userDomain.searchParameters},
      expandForm: state._userDomain.expandForm,
      loading: state._userDomain.loading,
      partialList: state._userDomain.partialList,
      owner: { type: '_userDomain', id: state._userDomain.id, 
      referenceName: 'domain', 
      listName: 'userWhiteListList', ref:state._userDomain, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserWhiteListSearch)
  }
  getUserWhiteListCreateForm = () => {
   	const {UserWhiteListCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "userWhiteList",
      data: state._userDomain.userWhiteListList,
      metaInfo: state._userDomain.userWhiteListListMetaInfo,
      count: state._userDomain.userWhiteListCount,
      currentPage: state._userDomain.userWhiteListCurrentPageNumber,
      searchFormParameters: state._userDomain.userWhiteListSearchFormParameters,
      loading: state._userDomain.loading,
      owner: { type: '_userDomain', id: state._userDomain.id, referenceName: 'domain', listName: 'userWhiteListList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserWhiteListCreateForm)
  }
  
  getUserWhiteListUpdateForm = () => {
    const userContext = null
  	const {UserWhiteListUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "userWhiteList",
      currentUpdateIndex: state._userDomain.currentUpdateIndex,
      owner: { type: '_userDomain', id: state._userDomain.id, listName: 'userWhiteListList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserWhiteListUpdateForm)
  }

  getSecUserSearch = () => {
    const {SecUserSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Sec User",
      role: "secUser",
      data: state._userDomain.secUserList,
      metaInfo: state._userDomain.secUserListMetaInfo,
      count: state._userDomain.secUserCount,
      currentPage: state._userDomain.secUserCurrentPageNumber,
      searchFormParameters: state._userDomain.secUserSearchFormParameters,
      searchParameters: {...state._userDomain.searchParameters},
      expandForm: state._userDomain.expandForm,
      loading: state._userDomain.loading,
      partialList: state._userDomain.partialList,
      owner: { type: '_userDomain', id: state._userDomain.id, 
      referenceName: 'domain', 
      listName: 'secUserList', ref:state._userDomain, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SecUserSearch)
  }
  getSecUserCreateForm = () => {
   	const {SecUserCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "secUser",
      data: state._userDomain.secUserList,
      metaInfo: state._userDomain.secUserListMetaInfo,
      count: state._userDomain.secUserCount,
      currentPage: state._userDomain.secUserCurrentPageNumber,
      searchFormParameters: state._userDomain.secUserSearchFormParameters,
      loading: state._userDomain.loading,
      owner: { type: '_userDomain', id: state._userDomain.id, referenceName: 'domain', listName: 'secUserList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SecUserCreateForm)
  }
  
  getSecUserUpdateForm = () => {
    const userContext = null
  	const {SecUserUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "secUser",
      currentUpdateIndex: state._userDomain.currentUpdateIndex,
      owner: { type: '_userDomain', id: state._userDomain.id, listName: 'secUserList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SecUserUpdateForm)
  }


  
  buildRouters = () =>{
  	const {UserDomainDashboard} = GlobalComponents
  	const {UserDomainPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/userDomain/:id/dashboard", component: UserDomainDashboard},
  	{path:"/userDomain/:id/preference", component: UserDomainPreference},
  	
  	
  	
  	{path:"/userDomain/:id/list/userWhiteListList", component: this.getUserWhiteListSearch()},
  	{path:"/userDomain/:id/list/userWhiteListCreateForm", component: this.getUserWhiteListCreateForm()},
  	{path:"/userDomain/:id/list/userWhiteListUpdateForm", component: this.getUserWhiteListUpdateForm()},
   	
  	{path:"/userDomain/:id/list/secUserList", component: this.getSecUserSearch()},
  	{path:"/userDomain/:id/list/secUserCreateForm", component: this.getSecUserCreateForm()},
  	{path:"/userDomain/:id/list/secUserUpdateForm", component: this.getSecUserUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Demo Data Service'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.userDomain)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  userDomain: state._userDomain,
  ...state,
}))(UserDomainBizApp)



