#include <stdio.h>
int def[100][100]={0};
static int t=0;

void printchess(int m ){
    for(int i=1;i<=m;i++){
        for(int j=1;j<=m;j++){
            printf("\t");
            printf("%d ",def[i][j]);
            if(j==m){
            	printf("\n");
            }
        }
    }
    system("pause");
}
void chess(int a,int b,int x,int y,int length)
{
    if(length==1){
        return;
    }
    t++;
    int tem =t;
    int l=length/2;

    if(x<a+l && y<b+l){    //当初始方块出现在左上角时
        chess(a,b,x,y,l);
    }
    else{
        def[a+l-1][b+l-1]=tem;
        chess(a,b,a+l-1,b+l-1,l);
    }
    if(x<a+l && y>=b+l){   //当初始方块出现在左下角时
        chess(a,b+l,x,y,l);
    }
    else{
        def[a+l-1][b+l]=tem;
        chess(a,b+l,a+l-1,b+l,l);
    }

    if(x>=a+l && y<b+l){    //当初始方块出现在右上角时
        chess(a+l,b,x,y,l);
    }
    else{
        def[a+l][b+l-1]=tem;
        chess(a+l,b,a+l,b+l-1,l);
    }
    if(x>=a+l && y>=b+l){    //当初始方块出现在右下角时
        chess(a+l,b+l,x,y,l);
    }
    else{
        def[a+l][b+l]=tem;
        chess(a+l,b+l,a+l,b+l,l);
    }
}
//分治法解决棋盘问题
int main(){
    int n,a,b,x,y,length,m;
    printf("输入行数：");
    scanf("%d",&length);
	printf("输入起始坐标，用空格隔开：");
	scanf("%d %d",&x,&y);

    a=b=1;
    m=length;
    chess(a,b,x,y,length);
    printchess(m);

}
