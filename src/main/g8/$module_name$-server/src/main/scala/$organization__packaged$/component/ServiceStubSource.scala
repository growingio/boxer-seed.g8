package $organization$.component

import com.google.inject.{ Provider, Provides }
import io.growing.boxer.grpc.stub.StubSource
import javax.inject.Singleton

@Provides
@Singleton
class ServiceStubSource extends Provider[StubSource] {

  override def get(): StubSource = {
    val source = new StubSource
    
  }

}
