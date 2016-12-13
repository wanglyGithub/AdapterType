# AdapterType
ListView显示不同的Item 布局
有时候在开发当中我们需要根据不同的数据类型为ListView 加载不同的布局文件！我们通常的操作是在 getView 中判断 position 取出相关的属性字段，
然后加以控制，但是这样不利于我们的编写更好的代码所以，就需要其他的方式实现！
好在ListView 提供了  getItemViewType(int position) 、getTypeCount() 两个方法、


一、定义类型常量：
 public static final int TYPE_COUNT = 2;
 public static final int TYPE_NOMAL = 0; //没有点赞
 public static final int TYPE_SUPPORT = 1;  //点赞
 
 
 二、重写 getItemViewType(int position) 、getTypeCount() 两个方法
 
 
/**
* 获取类型的总数
* @return
*/
 public static int getTypeCount() {
        return TYPE_COUNT;
}

    
/**
  * 获取Item的 类型
  * @param position
  * @return
  */
@Override
public int getItemViewType(int position) {
    if (0 == mRankDeials.get(position).getType()) { //正常 Item
           return TYPE_NOMAL;
     } else if (1 == mRankDeials.get(position).getType()) { //点赞的Item
            return TYPE_SUPPORT;
     } else {
        return 100;
     }
 }
 
 三、public View getView(int position, View convertView, ViewGroup parent)
        NomalHolder nomalHolder = null;
        SupportHoldler supportHoldler = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_NOMAL:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_xxxx_item, null);
                    nomalHolder = new NomalHolder(convertView);
                    convertView.setTag(nomalHolder);
                    break;
                case TYPE_SUPPORT:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_xxx_item, null);
                    supportHoldler = new SupportHoldler(convertView);
                    convertView.setTag(supportHoldler);
                    break;
            }

        } else {
            switch (type) {
                case TYPE_NOMAL:
                    nomalHolder = (NomalHolder) convertView.getTag();
                    break;
                case TYPE_SUPPORT:
                    supportHoldler = (SupportHoldler) convertView.getTag();
                    break;
            }
        }

        //TODO: 设置相关的数据JavaBean
        switch (type) {
            case TYPE_NOMAL:
                //TODO 绑定数据
                break;

            case TYPE_SUPPORT:
                 //TODO 绑定数据
                break;
        }

        return convertView;
 设置不同的布局的ViewHodler即可！
