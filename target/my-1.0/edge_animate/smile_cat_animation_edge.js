/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};


var resources = [
];
var symbols = {
"stage": {
   version: "2.0.1",
   minimumCompatibleVersion: "2.0.0",
   build: "2.0.1.268",
   baseState: "Base State",
   initialState: "Base State",
   gpuAccelerate: false,
   resizeInstances: false,
   content: {
         dom: [
         {
            id:'smile_catLayer_1',
            type:'image',
            rect:['93px','0px','619px','771px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2012.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_2',
            display:'none',
            type:'image',
            rect:['104px','7px','621px','764px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2022.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_3',
            display:'none',
            type:'image',
            rect:['104px','29px','621px','742px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2032.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_5',
            display:'none',
            type:'image',
            rect:['64px','77px','661px','689px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2052.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_6',
            display:'none',
            type:'image',
            rect:['9px','110px','756px','661px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2062.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_7',
            display:'none',
            type:'image',
            rect:['9px','103px','733px','663px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2072.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_8',
            display:'none',
            type:'image',
            rect:['40px','103px','707px','663px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2082.svg",'0px','0px']
         },
         {
            id:'smile_catLayer_9',
            display:'none',
            type:'image',
            rect:['104px','103px','661px','664px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"smile_catLayer%2092.svg",'0px','0px']
         }],
         symbolInstances: [

         ]
      },
   states: {
      "Base State": {
         "${_smile_catLayer_7}": [
            ["style", "top", '103px'],
            ["style", "left", '9px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_2}": [
            ["style", "top", '7px'],
            ["style", "left", '104px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_5}": [
            ["style", "top", '77px'],
            ["style", "left", '64px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_3}": [
            ["style", "top", '29px'],
            ["style", "left", '104px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_6}": [
            ["style", "top", '110px'],
            ["style", "left", '9px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_8}": [
            ["style", "top", '103px'],
            ["style", "left", '40px'],
            ["style", "display", 'none']
         ],
         "${_Stage}": [
            ["color", "background-color", 'rgba(255,255,255,1)'],
            ["style", "overflow", 'hidden'],
            ["style", "height", '771px'],
            ["style", "width", '982px']
         ],
         "${_smile_catLayer_9}": [
            ["style", "top", '103px'],
            ["style", "left", '104px'],
            ["style", "display", 'none']
         ],
         "${_smile_catLayer_1}": [
            ["style", "top", '0px'],
            ["style", "opacity", '1'],
            ["style", "left", '93px'],
            ["style", "display", 'block']
         ]
      }
   },
   timelines: {
      "Default Timeline": {
         fromState: "Base State",
         toState: "",
         duration: 2500,
         autoPlay: true,
         timeline: [
            { id: "eid43", tween: [ "style", "${_smile_catLayer_8}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid56", tween: [ "style", "${_smile_catLayer_8}", "display", 'block', { fromValue: 'none'}], position: 1500, duration: 0 },
            { id: "eid57", tween: [ "style", "${_smile_catLayer_8}", "display", 'none', { fromValue: 'block'}], position: 1750, duration: 0 },
            { id: "eid40", tween: [ "style", "${_smile_catLayer_5}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid50", tween: [ "style", "${_smile_catLayer_5}", "display", 'block', { fromValue: 'none'}], position: 750, duration: 0 },
            { id: "eid52", tween: [ "style", "${_smile_catLayer_5}", "display", 'none', { fromValue: 'block'}], position: 1000, duration: 0 },
            { id: "eid39", tween: [ "style", "${_smile_catLayer_3}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid48", tween: [ "style", "${_smile_catLayer_3}", "display", 'block', { fromValue: 'none'}], position: 500, duration: 0 },
            { id: "eid49", tween: [ "style", "${_smile_catLayer_3}", "display", 'none', { fromValue: 'block'}], position: 750, duration: 0 },
            { id: "eid37", tween: [ "style", "${_smile_catLayer_1}", "opacity", '1', { fromValue: '1'}], position: 250, duration: 0 },
            { id: "eid41", tween: [ "style", "${_smile_catLayer_6}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid51", tween: [ "style", "${_smile_catLayer_6}", "display", 'block', { fromValue: 'none'}], position: 1000, duration: 0 },
            { id: "eid53", tween: [ "style", "${_smile_catLayer_6}", "display", 'none', { fromValue: 'block'}], position: 1250, duration: 0 },
            { id: "eid44", tween: [ "style", "${_smile_catLayer_9}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid58", tween: [ "style", "${_smile_catLayer_9}", "display", 'block', { fromValue: 'none'}], position: 1750, duration: 0 },
            { id: "eid59", tween: [ "style", "${_smile_catLayer_9}", "display", 'none', { fromValue: 'block'}], position: 2500, duration: 0 },
            { id: "eid42", tween: [ "style", "${_smile_catLayer_7}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid54", tween: [ "style", "${_smile_catLayer_7}", "display", 'block', { fromValue: 'none'}], position: 1250, duration: 0 },
            { id: "eid55", tween: [ "style", "${_smile_catLayer_7}", "display", 'none', { fromValue: 'block'}], position: 1500, duration: 0 },
            { id: "eid45", tween: [ "style", "${_smile_catLayer_2}", "display", 'none', { fromValue: 'none'}], position: 0, duration: 0 },
            { id: "eid46", tween: [ "style", "${_smile_catLayer_2}", "display", 'block', { fromValue: 'none'}], position: 250, duration: 0 },
            { id: "eid47", tween: [ "style", "${_smile_catLayer_2}", "display", 'none', { fromValue: 'block'}], position: 500, duration: 0 },
            { id: "eid38", tween: [ "style", "${_smile_catLayer_1}", "display", 'none', { fromValue: 'block'}], position: 250, duration: 0 }         ]
      }
   }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-153954801");
