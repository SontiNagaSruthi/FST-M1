import xml.etree.ElementTree as ET
import pandas as pd

xml_data=open("./properties.xml","r").read()
root=ET.XML(xml_data)

data=[]
cols=[]

for i, child in enumerate(root):
    data.append([subchild.text for subchild in child])
    cols.append(child.tag)

df=pd.DataFrame(data).T
df.columns=cols
print(df)