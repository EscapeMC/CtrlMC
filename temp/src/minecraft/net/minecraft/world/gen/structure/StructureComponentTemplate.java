package net.minecraft.world.gen.structure;

import java.util.Map;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public abstract class StructureComponentTemplate extends StructureComponent {
   private static final PlacementSettings field_186179_d = new PlacementSettings();
   protected Template field_186176_a;
   protected PlacementSettings field_186177_b;
   protected BlockPos field_186178_c;

   public StructureComponentTemplate() {
      this.field_186177_b = field_186179_d.func_186222_a(true).func_186225_a(Blocks.field_150350_a);
   }

   public StructureComponentTemplate(int p_i46662_1_) {
      super(p_i46662_1_);
      this.field_186177_b = field_186179_d.func_186222_a(true).func_186225_a(Blocks.field_150350_a);
   }

   protected void func_186173_a(Template p_186173_1_, BlockPos p_186173_2_, PlacementSettings p_186173_3_) {
      this.field_186176_a = p_186173_1_;
      this.func_186164_a(EnumFacing.NORTH);
      this.field_186178_c = p_186173_2_;
      this.field_186177_b = p_186173_3_;
      this.func_186174_h();
   }

   protected void func_143012_a(NBTTagCompound p_143012_1_) {
      p_143012_1_.func_74768_a("TPX", this.field_186178_c.func_177958_n());
      p_143012_1_.func_74768_a("TPY", this.field_186178_c.func_177956_o());
      p_143012_1_.func_74768_a("TPZ", this.field_186178_c.func_177952_p());
   }

   protected void func_143011_b(NBTTagCompound p_143011_1_) {
      this.field_186178_c = new BlockPos(p_143011_1_.func_74762_e("TPX"), p_143011_1_.func_74762_e("TPY"), p_143011_1_.func_74762_e("TPZ"));
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.field_186177_b.func_186223_a(p_74875_3_);
      this.field_186176_a.func_186253_b(p_74875_1_, this.field_186178_c, this.field_186177_b);
      Map<BlockPos, String> map = this.field_186176_a.func_186258_a(this.field_186178_c, this.field_186177_b);

      for(BlockPos blockpos : map.keySet()) {
         String s = (String)map.get(blockpos);
         this.func_186175_a(s, blockpos, p_74875_1_, p_74875_2_, p_74875_3_);
      }

      return true;
   }

   protected abstract void func_186175_a(String var1, BlockPos var2, World var3, Random var4, StructureBoundingBox var5);

   private void func_186174_h() {
      Rotation rotation = this.field_186177_b.func_186215_c();
      BlockPos blockpos = this.field_186176_a.func_186257_a(rotation);
      this.field_74887_e = new StructureBoundingBox(0, 0, 0, blockpos.func_177958_n(), blockpos.func_177956_o() - 1, blockpos.func_177952_p());
      switch(rotation) {
      case NONE:
      default:
         break;
      case CLOCKWISE_90:
         this.field_74887_e.func_78886_a(-blockpos.func_177958_n(), 0, 0);
         break;
      case COUNTERCLOCKWISE_90:
         this.field_74887_e.func_78886_a(0, 0, -blockpos.func_177952_p());
         break;
      case CLOCKWISE_180:
         this.field_74887_e.func_78886_a(-blockpos.func_177958_n(), 0, -blockpos.func_177952_p());
      }

      this.field_74887_e.func_78886_a(this.field_186178_c.func_177958_n(), this.field_186178_c.func_177956_o(), this.field_186178_c.func_177952_p());
   }

   public void func_181138_a(int p_181138_1_, int p_181138_2_, int p_181138_3_) {
      super.func_181138_a(p_181138_1_, p_181138_2_, p_181138_3_);
      this.field_186178_c = this.field_186178_c.func_177982_a(p_181138_1_, p_181138_2_, p_181138_3_);
   }
}
